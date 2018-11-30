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
