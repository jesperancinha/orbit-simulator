b: build
remove-lock-files:
	find . -name "package-lock.json" | xargs -I {} rm {}; \
	find . -name "yarn.lock" | xargs -I {} rm {};
update: remove-lock-files
	npm install -g npm-check-updates
	cd concert-demos-gui;\
 	npx browserslist --update-db;\
 	ncu -u;\
 	yarn
build:
	mvn clean install
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash -s -- $(PARAMS)
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update
update-repo-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/update-all-repo-prs.sh | bash
accept-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/acceptPR.sh | bash
