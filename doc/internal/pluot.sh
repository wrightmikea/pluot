#!/bin/bash
echo "/home/mike/github/wrightmikea/pluot/doc/internal/pluot.sh"

export BASEDIR=/home/mike/github/wrightmikea/pluot
export GRADLE_HOME=/home/mike/pjm/common/gradle/gradle-1.6
export IDEA_HOME=/home/mike/pjm/common/jetbrains/iu-12.1.3/idea-IU-129.451
export JAVA_HOME=/home/mike/pjm/common/oracle/64/jdk1.7.0_07
export PATH=$BASEDIR/bin:$JAVA_HOME/bin:$IDEA_HOME/bin:$GRADLE_HOME/bin:$PATH
#export PLUOT_REPO_URL=http://nexus.example.com:8081/nexus/content/repositories/snapshots-dev
export PLUOT_REPO_URL=file:///home/mike/pluot-repo

cd $BASEDIR

echo "pluot - IU12.1.3(markdown),jdk170_07(64),gradle 1.6"
echo "--- pluot repo url: $PLUOT_REPO_URL"
