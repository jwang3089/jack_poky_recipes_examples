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
    echo "****************** JACK 1 *********************" > LOG2.0.1
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG2.0.1
    echo "0: INCLUDE = ${INCLUDE}" >> LOG2.0.1
    echo "0: SRC_URI = ${SRC_URI}" >> LOG2.0.1
    echo "0: WORKDIR = ${WORKDIR}" >> LOG2.0.1
    echo "2: S = ${S}" >> LOG2.0.1
    echo "3: pwd = $(pwd)" >> LOG2.0.1
    echo "4: ls= $(ls)" >> LOG2.0.1
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG2.0.1
    echo "make -f Makefile" >> LOG2.0.1
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG2.0.1
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG2.0.1
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG2.0.1
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG2.0.1
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG2.0.1
    echo "PACKAGES = ${PACKAGES}" >> LOG2.0.1
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG2.0.1
    echo "BPN=${BPN}" >> LOG2.0.1
    echo "BP=${BP}" >> LOG2.0.1
    echo "PN=${PN}" >> LOG2.0.1
    echo "PR=${PR}" >> LOG2.0.1
    echo "PV=${PV}" >> LOG2.0.1
    echo "PE=${PE}" >> LOG2.0.1
    echo "PF=${PF}" >> LOG2.0.1
    echo "S=${S}" >> LOG2.0.1
    echo "P=${P}" >> LOG2.0.1
    echo "B=${B}" >> LOG2.0.1
    echo "D=${D}" >> LOG2.0.1
    echo "sysconfdir=${sysconfdir}" >> LOG2.0.1
    echo "localdir=${localdir}" >> LOG2.0.1
    echo "dir = ${dir}" >> LOG2.0.1
    echo "libdir=${libdir}" >> LOG2.0.1
    echo "bindir=${bindir}" >> LOG2.0.1
    echo "sbindir=${sbindir}" >> LOG2.0.1
    echo "datadir=${datadir}" >> LOG2.0.1
    echo "includedir=${includedir}" >> LOG2.0.1
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG2.0.1
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG2.0.1
    echo "systemd_libdir=${systemd_libdir}" >> LOG2.0.1
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG2.0.1
    echo "MACHINE=${MACHINE}" >> LOG2.0.1
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2.0.1
    echo "TARGET_OS=${TARGET_OS}" >> LOG2.0.1
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG2.0.1
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG2.0.1
    echo "TOPDIR=${TOPDIR}" >> LOG2.0.1
    echo "TMPDIR=${TMPDIR}" >> LOG2.0.1
    echo "LAYERDIR=${LAYERDIR}" >> LOG2.0.1
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG2.0.1
    echo "FILESPATH=${FILESPATH}" >> LOG2.0.1
    echo "FILE=${FILE}" >> LOG2.0.1
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG2.0.1
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG2.0.1
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG2.0.1
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2.0.1
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG2.0.1
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG2.0.1
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG2.0.1
    echo "PROVIDES=${PROVIDES}" >> LOG2.0.1
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG2.0.1
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG2.0.1
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG2.0.1
    echo "RPROVIDES=${RPROVIDES}" >> LOG2.0.1
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG2.0.1
    echo "RREPLACES=${RREPLACES}" >> LOG2.0.1
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG2.0.1

    echo "env:" >> LOG2.0.1
    echo "$(env)" >> LOG2.0.1
    echo "export:" >> LOG2.0.1
    echo "$(export)" >> LOG2.0.1
#    make clean
    make
}

do_compile_append() {
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG2.0.1


}

do_clean_apped() {
    echo "cleanup" >> LOG2.0.1
}



do_install_append () {

    install -d ${D}${bindir}
    install -m 0755 ${S}/Makefile ${D}${bindir} 
    install -m 0755 ${S}/main.c  ${D}${bindir}
}

