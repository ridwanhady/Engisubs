find -name *.java > sources.txt
javac @sources.txt
find -name *.class > classes.txt
jar cfm ../../../Engisubs.jar Engisubs.mf @classes.txt engisubs/ui/ASSETS/*
