jobs:
    - script: >
        job('super-seed') {
            scm {
                git {
                    remote {
                        url ('https://github.com/shashwot/go-assignment.git')
                        credentials('github-ssh')
                    }
                }
            }
            steps {
                dsl {
                    external('jobdsl/**/*.groovy')
                    removeAction('DELETE')
                }
            }
        }