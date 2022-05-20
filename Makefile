clean:
	.\gradlew clean

build:
	.\gradlew clean build

install:
	.\gradlew clean install

run:
	.\gradlew run

lint:
	.\gradlew checkstyleMain

update-deps:
	.\gradlew useLatestVersions

run-dist:
	.\build\install\app\bin\app

build-run: build run

install-run: install run-dist

.PHONY: build