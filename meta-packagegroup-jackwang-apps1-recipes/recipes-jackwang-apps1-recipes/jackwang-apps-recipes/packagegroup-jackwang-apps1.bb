#SUMMARY = "Jack Wang Apps"
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

#PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit packagegroup

#PACKAGES = "${PN}"

#RDEPENDS_${PN} = " \
#        jackwang-app-recipe1 \
#        jackwang-app-recipe2 \
#        jackwang-app-recipe3 \
#        jackwang-app-recipe4 \
#"



PR = "r14"
SUMMARY = "Provides driver packages for jack wang "
DESCRIPTION = "Meta group for "

inherit packagegroup

PROVIDES = "${PN}"

# Use all modules if not specified otherwise
JACK_APPS_FEATURES ?= "jack_apps"

RDEPENDS_${PN} = " \
    ${@bb.utils.contains('JACK_APPS_FEATURES', 'jack_apps', 'jackwang-app1-recipe1 jackwang-app1-recipe2', '', d)} \
"

