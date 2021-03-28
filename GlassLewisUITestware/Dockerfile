FROM ubuntu
RUN apt-get update && apt-get install -y \
  default-jre \
  maven \
  git
RUN apt update
RUN apt -y install default-jre
RUN apt -y install maven
RUN apt -y install firefox xvfb
RUN apt -y install git
RUN apt -y install curl
RUN curl -LO https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb
RUN rm google-chrome-stable_current_amd64.deb
RUN git clone https://github.com/AvinashReddy-Git/GlassLewisAssignment.git
ENTRYPOINT ["tail", "-f", "/dev/null"]