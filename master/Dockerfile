FROM jenkins/jenkins:lts

LABEL maintainer="shashwot@gmail.com"

COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt

ENV JENKINS_HOME /var/jenkins_home

ARG JAVA_OPTS
ENV JAVA_OPTS "-Djenkins.install.runSetupWizard=false ${JAVA_OPTS:-}"

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
