# SUMMARY = "Intel gma500_gfx fix for certain hardware"
DESCRIPTION = "Avoid inserting gma500_gfx module for certain hardware devices."
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

# Copyright (C) 2014 Boundary Devices
# SUMMARY = "Hello World Demo"
#CFLAGS_prepend = "-I${S}/include"
#INCLUDE = "-I${S}/include"

#
#FILESEXTRAPATHS_prepend := "${THISDIR}/files:" 
#
SUMMARY = "Hello World Demo"
SECTION = "apps"
LICENSE = "CLOSED"

#NOUSE ONLY INFORMATION APP_NAME = "hello-world"
APP_NAME = "jack-world"
TARGET_CC_ARCH += "${LDFLAGS}"


USER="root"
DEPENDS = "glibc openssl"
#DEPENDS = "glibc"


SRC_URI ="file://main.c \
	  file://Makefile \
          "

# 0) 
#
S = "${WORKDIR}"

#do_compile() {
#    make
#}
#do_compile() {
do_compile_append() {
    echo "****************** JACK 1 *********************" > LOG230
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG230
    echo "0: INCLUDE = ${INCLUDE}" >> LOG230
    echo "0: SRC_URI = ${SRC_URI}" >> LOG230
    echo "0: WORKDIR = ${WORKDIR}" >> LOG230
    echo "2: S = ${S}" >> LOG230
    echo "3: pwd = $(pwd)" >> LOG230
    echo "4: ls= $(ls)" >> LOG230
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG230
    echo "make -f Makefile" >> LOG230
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG230
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG230
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG230
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG230
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG230
    echo "PACKAGES = ${PACKAGES}" >> LOG230
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG230
    echo "BPN=${BPN}" >> LOG230
    echo "BP=${BP}" >> LOG230
    echo "PN=${PN}" >> LOG230
    echo "PR=${PR}" >> LOG230
    echo "PV=${PV}" >> LOG230
    echo "PE=${PE}" >> LOG230
    echo "PF=${PF}" >> LOG230
    echo "S=${S}" >> LOG230
    echo "P=${P}" >> LOG230
    echo "B=${B}" >> LOG230
    echo "D=${D}" >> LOG230
    echo "sysconfdir=${sysconfdir}" >> LOG230
    echo "localdir=${localdir}" >> LOG230
    echo "dir = ${dir}" >> LOG230
    echo "libdir=${libdir}" >> LOG230
    echo "bindir=${bindir}" >> LOG230
    echo "sbindir=${sbindir}" >> LOG230
    echo "datadir=${datadir}" >> LOG230
    echo "includedir=${includedir}" >> LOG230
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG230
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG230
    echo "systemd_libdir=${systemd_libdir}" >> LOG230
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG230
    echo "MACHINE=${MACHINE}" >> LOG230
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG230
    echo "TARGET_OS=${TARGET_OS}" >> LOG230
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG230
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG230
    echo "TOPDIR=${TOPDIR}" >> LOG230
    echo "TMPDIR=${TMPDIR}" >> LOG230
    echo "LAYERDIR=${LAYERDIR}" >> LOG230
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG230
    echo "FILESPATH=${FILESPATH}" >> LOG230
    echo "FILE=${FILE}" >> LOG230
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG230
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG230
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG230
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG230
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG230
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG230
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG230
    echo "PROVIDES=${PROVIDES}" >> LOG230
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG230
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG230
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG230
    echo "RPROVIDES=${RPROVIDES}" >> LOG230
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG230
    echo "RREPLACES=${RREPLACES}" >> LOG230
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG230

    echo "env:" >> LOG230
    echo "$(env)" >> LOG230
    echo "export:" >> LOG230
    echo "$(export)" >> LOG230
#    make clean
    make
}

do_compile_append() {
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG230


}

do_clean_apped() {
    echo "cleanup" >> LOG230
}



do_install_append () {

    install -d ${D}${bindir}
    install -m 0755 ${S}/Makefile ${D}${bindir} 
    install -m 0755 ${S}/main.c  ${D}${bindir}
}

