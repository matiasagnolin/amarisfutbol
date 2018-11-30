def gitUrl = 'git://github.com/matiasagnolin/amarisfutbol'

job('test-job') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}
