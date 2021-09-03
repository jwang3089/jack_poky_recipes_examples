SUMMARY = "Jack Wang Apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = " \
        jackwang-app-recipe1 \
        jackwang-app-recipe2 \
        jackwang-app-recipe3 \
        jackwang-app-recipe4 \
"
