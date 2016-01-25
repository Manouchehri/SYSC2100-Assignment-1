#!/bin/bash
zip -9r "$(printf "r%s.%s - %s.zip" "$(git rev-list --count HEAD)" "$(git rev-parse --short HEAD)" "$(date --utc --iso-8601=seconds | sed s/:/./g)")" src/ out/ *.txt *.md *.java *.class
