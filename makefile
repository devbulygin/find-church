check-deps:
	./gradlew dependencyUpdates -Drevision=release

dev:
	./gradlew run

setup:
	gradle wrapper

clean:
	./gradlew clean

build:
	./gradlew clean build

start: dev

install:
	./gradlew installDist

lint:
	./gradlew checkstyleMain

test:
	./gradlew test


.PHONY: build