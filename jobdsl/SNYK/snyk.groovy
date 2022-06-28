job('SECURITY-SAST-SNYK') {
  steps {
    shell('''cd ${WORKSPACE}
SNYK_TOKEN="${snyk_auth}" snyk test 
SNYK_TOKEN="${snyk_auth}" snyk monitor
      ''')
  }
}