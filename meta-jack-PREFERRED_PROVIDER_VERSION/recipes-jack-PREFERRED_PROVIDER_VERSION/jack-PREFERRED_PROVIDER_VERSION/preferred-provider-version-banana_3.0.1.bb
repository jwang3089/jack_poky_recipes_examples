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
    echo "****************** JACK 1 *********************" > LOG3
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG3
    echo "0: INCLUDE = ${INCLUDE}" >> LOG3
    echo "0: SRC_URI = ${SRC_URI}" >> LOG3
    echo "0: WORKDIR = ${WORKDIR}" >> LOG3
    echo "2: S = ${S}" >> LOG3
    echo "3: pwd = $(pwd)" >> LOG3
    echo "4: ls= $(ls)" >> LOG3
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG3
    echo "make -f Makefile" >> LOG3
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG3
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG3
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG3
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG3
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG3
    echo "PACKAGES = ${PACKAGES}" >> LOG3
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG3
    echo "BPN=${BPN}" >> LOG3
    echo "BP=${BP}" >> LOG3
    echo "PN=${PN}" >> LOG3
    echo "PR=${PR}" >> LOG3
    echo "PV=${PV}" >> LOG3
    echo "PE=${PE}" >> LOG3
    echo "PF=${PF}" >> LOG3
    echo "S=${S}" >> LOG3
    echo "P=${P}" >> LOG3
    echo "B=${B}" >> LOG3
    echo "D=${D}" >> LOG3
    echo "sysconfdir=${sysconfdir}" >> LOG3
    echo "localdir=${localdir}" >> LOG3
    echo "dir = ${dir}" >> LOG3
    echo "libdir=${libdir}" >> LOG3
    echo "bindir=${bindir}" >> LOG3
    echo "sbindir=${sbindir}" >> LOG3
    echo "datadir=${datadir}" >> LOG3
    echo "includedir=${includedir}" >> LOG3
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG3
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG3
    echo "systemd_libdir=${systemd_libdir}" >> LOG3
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG3
    echo "MACHINE=${MACHINE}" >> LOG3
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG3
    echo "TARGET_OS=${TARGET_OS}" >> LOG3
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG3
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG3
    echo "TOPDIR=${TOPDIR}" >> LOG3
    echo "TMPDIR=${TMPDIR}" >> LOG3
    echo "LAYERDIR=${LAYERDIR}" >> LOG3
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG3
    echo "FILESPATH=${FILESPATH}" >> LOG3
    echo "FILE=${FILE}" >> LOG3
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG3
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG3
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG3
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG3
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG3
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG3
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG3
    echo "PROVIDES=${PROVIDES}" >> LOG3
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG3
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG3
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG3
    echo "RPROVIDES=${RPROVIDES}" >> LOG3
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG3
    echo "RREPLACES=${RREPLACES}" >> LOG3
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG3

    echo "env:" >> LOG3
    echo "$(env)" >> LOG3
    echo "export:" >> LOG3
    echo "$(export)" >> LOG3
#    make clean
    make
}

do_compile_append() {
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG3


}

do_clean_apped() {
    echo "cleanup" >> LOG3
}



do_install_append () {

    install -d ${D}${bindir}
    install -m 0755 ${S}/Makefile ${D}${bindir} 
    install -m 0755 ${S}/main.c  ${D}${bindir}
}

