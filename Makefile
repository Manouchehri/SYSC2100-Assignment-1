CHK_SOURCES = src/ConfigurationCounting.java
outdir = out

.PHONY: run watch

all:
	javac -d $(outdir) $(CHK_SOURCES)

run:
	javac -d $(outdir) $(CHK_SOURCES)
	java -cp $(outdir)/ ConfigurationCounting
	
# sudo apt-get -y install inotify-tools
watch:
	while inotifywait -qqe modify $(CHK_SOURCES); do \
		javac -d $(outdir) $(CHK_SOURCES) \
		&& java -cp $(outdir)/ ConfigurationCounting; \
		done;
