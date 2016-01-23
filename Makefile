CHK_SOURCES = src/ConfigurationCounting.java
CHK_SOURCES_JAVA = $(filter %.java,$(CHK_SOURCES))
outdir = out

.PHONY: run watch

all:
	javac -d $(outdir) $(CHK_SOURCES_JAVA)

run:
	javac -d $(outdir) $(CHK_SOURCES_JAVA)
	java -cp $(outdir)/ ConfigurationCounting
	
# sudo apt-get -y install inotify-tools
watch:
	while inotifywait -qqe modify $(CHK_SOURCES_JAVA); do \
		javac -d $(outdir) $(CHK_SOURCES_JAVA) \
		&& java -cp $(outdir)/ ConfigurationCounting; \
		done;
