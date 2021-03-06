job('SECURITY-SAST-SNYK') {
  wrappers {
        credentialsBinding {
            string('snyk_auth', 'snyk_auth')
        }
        golang('go_lang')
        preBuildCleanup { // Clean before build
            includePattern('**/target/**')
            deleteDirectories()
            cleanupParameter('CLEANUP')
        }
        publishers {
        cleanWs { // Clean after build
            cleanWhenAborted(true)
            cleanWhenFailure(true)
            cleanWhenNotBuilt(false)
            cleanWhenSuccess(true)
            cleanWhenUnstable(true)
            deleteDirs(true)
            notFailBuild(true)
            disableDeferredWipeout(true)
            patterns {
                pattern {
                    type('EXCLUDE')
                    pattern('.propsfile')
                }
                pattern {
                    type('INCLUDE')
                    pattern('.gitignore')
                }
            }
        }
        }
    scm {
      git {
          remote {
              url ('https://github.com/shashwot/go-assignment.git')
              credentials('github_ssh')
          }
      }
    }
  steps {
    shell('''cd ${WORKSPACE}
SNYK_TOKEN="${snyk_auth}" snyk test 
SNYK_TOKEN="${snyk_auth}" snyk monitor
      ''')
  }
  }
}