job('SECURITY-SAST-SNYK') {
  wrappers {
        credentialsBinding {
            string('snyk_auth', 'snyk_auth')
        }
  steps {
    shell('''cd ${WORKSPACE}
SNYK_TOKEN="${snyk_auth}" snyk test 
SNYK_TOKEN="${snyk_auth}" snyk monitor
      ''')
  }
  }
}