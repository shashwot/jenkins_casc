FROM jenkins/jenkins:lts

LABEL maintainer="shashwot@gmail.com"
USER root
RUN apt update -y && \
    apt upgrade -y && \
    DEBIAN_FRONTEND=noninteractive \
    apt-get install --no-install-recommends --assume-yes \
    docker.io
RUN apt install wget -y && \
    wget -qO /usr/bin/yq https://github.com/mikefarah/yq/releases/latest/download/yq_linux_amd64 && \
    chmod +x /usr/bin/yq

USER jenkins

COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt

ENV JENKINS_HOME /var/jenkins_home

ARG JAVA_OPTS
ENV JAVA_OPTS "-Djenkins.install.runSetupWizard=false ${JAVA_OPTS:-}"

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt