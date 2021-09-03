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
#S = "${WORKDIR}"

#do_compile() {
#    make
#}
#do_compile() {
do_compile_append() {
    echo "****************** JACK 1 *********************" > LOG2
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG2
    echo "0: INCLUDE = ${INCLUDE}" >> LOG2
    echo "0: SRC_URI = ${SRC_URI}" >> LOG2
    echo "0: WORKDIR = ${WORKDIR}" >> LOG2
    echo "2: S = ${S}" >> LOG2
    echo "3: pwd = $(pwd)" >> LOG2
    echo "4: ls= $(ls)" >> LOG2
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG2
    echo "make -f Makefile" >> LOG2
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG2
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG2
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG2
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG2
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG2
    echo "PACKAGES = ${PACKAGES}" >> LOG2
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG2
    echo "BPN=${BPN}" >> LOG2
    echo "BP=${BP}" >> LOG2
    echo "PN=${PN}" >> LOG2
    echo "PR=${PR}" >> LOG2
    echo "PV=${PV}" >> LOG2
    echo "PE=${PE}" >> LOG2
    echo "PF=${PF}" >> LOG2
    echo "S=${S}" >> LOG2
    echo "P=${P}" >> LOG2
    echo "B=${B}" >> LOG2
    echo "D=${D}" >> LOG2
    echo "sysconfdir=${sysconfdir}" >> LOG2
    echo "localdir=${localdir}" >> LOG2
    echo "dir = ${dir}" >> LOG2
    echo "libdir=${libdir}" >> LOG2
    echo "bindir=${bindir}" >> LOG2
    echo "sbindir=${sbindir}" >> LOG2
    echo "datadir=${datadir}" >> LOG2
    echo "includedir=${includedir}" >> LOG2
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG2
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG2
    echo "systemd_libdir=${systemd_libdir}" >> LOG2
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG2
    echo "MACHINE=${MACHINE}" >> LOG2
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2
    echo "TARGET_OS=${TARGET_OS}" >> LOG2
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG2
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG2
    echo "TOPDIR=${TOPDIR}" >> LOG2
    echo "TMPDIR=${TMPDIR}" >> LOG2
    echo "LAYERDIR=${LAYERDIR}" >> LOG2
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG2
    echo "FILESPATH=${FILESPATH}" >> LOG2
    echo "FILE=${FILE}" >> LOG2
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG2
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG2
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG2
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG2
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG2
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG2
    echo "PROVIDES=${PROVIDES}" >> LOG2
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG2
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG2
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG2
    echo "RPROVIDES=${RPROVIDES}" >> LOG2
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG2
    echo "RREPLACES=${RREPLACES}" >> LOG2
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG2

    echo "env:" >> LOG2
    echo "$(env)" >> LOG2
    echo "export:" >> LOG2
    echo "$(export)" >> LOG2
#    make clean
    make
}

do_compile_append() {
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG2


}

do_clean_apped() {
    echo "cleanup" >> LOG2
}



do_install_append () {

    install -d ${D}${bindir}
    install -m 0755 ${S}/Makefile ${D}${bindir} 
    install -m 0755 ${S}/main.c  ${D}${bindir}
}

