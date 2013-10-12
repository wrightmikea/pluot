github/wrightmikea/pluot/doc/internal/pl-dev.md
(see: http://daringfireball.net/projects/markdown/syntax)

# Documentation for "platform" developers (working on the Pluot implementation)

## one time git setup
> 1. fork the pluot repo
> 2. clone your fork
> 3. cd to your fork
> 4. git checkout -b develop
> 5. git pull origin develop

## feature development git workflow
> 1. git checkout -b feature
> 2. edit/build changes (see below)
> 3. test changes (see below)
> 4. use github to send a pull request
>

## one time development setup
> 1. install JDK 1.7
> 2. install gradle 1.6
> 3. set environment variables (see pluot/doc/internal/pluot.sh or pluot.cmd examples)
> 4. use an IDE (preferably IntelliJ IDEA 12.1.3 or newer) to import the gradle project. The project uses Language Level 7 (e.g. "Diamonds" syntax).
> 5. optionally install the IDEA markdown plug-in

## building, running unit tests
> command line build:
>
        gradle clean check
>
> or use IDEA to make the project and run all (or individual) tests

## publishing
> publishing artifacts for dependent projects (e.g. dashboard or wheresmytrain):
>
        gradle publish
>
> assuming the PLUOT_REPO_URL environment variable is set to a writeable directory
> or to a suitable repo url for a maven repo server (like nexus).
> See the sample urls in the root build.gradle file comments.

## run downstream tests
> see dashboard/doc/internal/pl-dev.md or wheresmytrain/doc/internal/app-dev.md


----