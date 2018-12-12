def gitUrl = 'https://github.com/matiasagnolin/amarisfutbol'

createCiJob("futbol-app", gitUrl, "pom.xml")

def createCiJob(def jobName, def gitUrl, def pomFile) {
  job("${jobName}-1-ci") {
    parameters {
      stringParam("BRANCH", "develop", "Define TAG or BRANCH to build from")
    }
    scm {
      git {
        remote {
          url(gitUrl)
        }
        extensions {
          cleanAfterCheckout()
        }
      }
    }
    wrappers {
      colorizeOutput()
      preBuildCleanup()
    }
    triggers {
      scm('30/H * * * *')
      githubPush()
    }
    steps {
      maven {
          goals('clean versions:set -DnewVersion=DEV-\${BUILD_NUMBER}')
          mavenInstallation('Maven 3.3.3')
          rootPOM( pomFile )
          mavenOpts('-Xms512m -Xmx1024m')
          providedGlobalSettings('bc30ebe0-68e1-4fa7-ab30-38092113a63c')
      }
      maven {
        goals('clean deploy')
        mavenInstallation('Maven 3.3.3')
        rootPOM(pomFile)
        mavenOpts('-Xms512m -Xmx1024m')
        providedGlobalSettings('bc30ebe0-68e1-4fa7-ab30-38092113a63c')
      }
    }
    publishers {
      chucknorris()
      publishCloneWorkspace('**', '', 'Any', 'TAR', true, null)
      downstreamParameterized {
        trigger("${jobName}-2-sonar") {
          parameters {
            currentBuild()
          }
        }
      }
    }
  }
}
<<<<<<< HEAD
/*
def createSonarJob(def jobName, def gitUrl, def pomFile) {
  job("${jobName}-2-sonar") {
    parameters {
      stringParam("BRANCH", "master", "Define TAG or BRANCH to build from")
    }
    scm {
      cloneWorkspace("${jobName}-1-ci")
    }
    wrappers {
      colorizeOutput()
      preBuildCleanup()
    }
    steps {
      maven {
        goals('org.jacoco:jacoco-maven-plugin:0.7.4.201502262128:prepare-agent install -Psonar')
        mavenInstallation('Maven 3.3.3')
        rootPOM(pomFile)
        mavenOpts('-Xms512m -Xmx1024m')
        providedGlobalSettings('bc30ebe0-68e1-4fa7-ab30-38092113a63c')
      }
      maven {
        goals('sonar:sonar -Psonar')
        mavenInstallation('Maven 3.3.3')
        rootPOM(pomFile)
        mavenOpts('-Xms512m -Xmx1024m')
        providedGlobalSettings('bc30ebe0-68e1-4fa7-ab30-38092113a63c')
      }
    }
    publishers {
      chucknorris()
      downstreamParameterized {
        trigger("${jobName}-3-docker-build") {
          parameters {
            currentBuild()
          }
        }
      }
    }
  }
}

def createDockerBuildJob(def jobName, def folder) {

  println "############################################################################################################"
  println "Creating Docker Build Job for ${jobName} "
  println "############################################################################################################"

  job("${jobName}-3-docker-build") {
    logRotator {
        numToKeep(10)
    }
    scm {
      cloneWorkspace("${jobName}-1-ci")
    }
    steps {
      steps {
        shell("cd ${folder} && sudo /usr/bin/docker build -t conference-${folder} .")
      }
    }
    publishers {
      chucknorris()
      downstreamParameterized {
        trigger("${jobName}-4-docker-start-container") {
          parameters {
            currentBuild()
          }
        }
      }
    }
  }
}

def createDockerStartJob(def jobName, def folder, def port) {

  println "############################################################################################################"
  println "Creating Docker Start Job for ${jobName} "
  println "############################################################################################################"

  job("${jobName}-4-docker-start-container") {
    logRotator {
        numToKeep(10)
    }
    steps {
      steps {
        shell('echo "Stopping Docker Container first"')
        shell("sudo /usr/bin/docker stop \$(sudo /usr/bin/docker ps -a -q --filter=\"name=conference-${folder}\") | true ")
        shell("sudo /usr/bin/docker rm \$(sudo /usr/bin/docker ps -a -q --filter=\"name=conference-${folder}\") | true ")
        shell('echo "Starting Docker Container"')
        shell("sudo /usr/bin/docker run -d --name futbol-${folder} -p=${port}:8080 futbol-${folder}")
      }
    }
    publishers {
      chucknorris()
    }
  }
}

def createDockerStopJob(def jobName, def folder) {

  println "############################################################################################################"
  println "Creating Docker Stop Job for ${jobName} "
  println "############################################################################################################"

  job("${jobName}-5-docker-stop-container") {
    logRotator {
        numToKeep(10)
    }
    steps {
      steps {
        shell("sudo /usr/bin/docker stop \$(sudo /usr/bin/docker ps -a -q --filter=\"name=conference-${folder}\")")
        shell("sudo /usr/bin/docker rm \$(sudo /usr/bin/docker ps -a -q --filter=\"name=conference-${folder}\")")
      }
    }
    publishers {
      chucknorris()
    }
  }
}
/*
buildPipelineView('Pipeline') {
    filterBuildQueue()
    filterExecutors()
    title('Futbol App CI Pipeline')
    displayedBuilds(5)
    selectedJob("futbol-app-1-ci")
    alwaysAllowManualTrigger()
    refreshFrequency(60)
}

listView('Futbol App') {
    description('')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/conference-app-.)
  /*  }
    columns {
        status()
        buildButton()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
    }
}*/
=======
>>>>>>> develop
