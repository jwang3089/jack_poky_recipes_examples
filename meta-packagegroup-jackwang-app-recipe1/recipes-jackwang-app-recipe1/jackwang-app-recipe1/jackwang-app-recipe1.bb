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
LICENSE = "CLOSED"

PR = "r5"
PV = "2.0.1"

# recipe: jack1
# PV: 2.0.1
# PR: r5
# jack1/2.0.1-r5

#localdir = "/usr/local"
#bindir = "${localdir}/bin"

TARGET_CC_ARCH += "${LDFLAGS}"


# LIBRARIES WITH .bb 
# main.c: struct rsa_meth_st *sample;

SRC_URI ="file://app-recipe1.c \
	  file://Makefile \
          "

#0: WORKDIR = /media/jackbwang/MISC/YOCTO/poky/build/tmp/work/core2-64-poky-linux/jackwang-app-recipe1/1.0-r0
#2: S = /media/jackbwang/MISC/YOCTO/poky/build/tmp/work/core2-64-poky-linux/jackwang-app-recipe1/1.0-r0/jackwang-app-recipe1-1.0
#tmp/work/core2-64-poky-linux/jackwang-app-recipe1/1.0-r0
#tmp/work/core2-64-poky-linux/jackwang-app-recipe1/2.0.1-r5/
S = "${WORKDIR}"

do_compile_append() {
    echo "****************** JACK 1 *********************" > LOG4
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG4
    echo "0: INCLUDE = ${INCLUDE}" >> LOG4
    echo "0: SRC_URI = ${SRC_URI}" >> LOG4
    echo "0: WORKDIR = ${WORKDIR}" >> LOG4
    echo "2: S = ${S}" >> LOG4
    echo "3: pwd = $(pwd)" >> LOG4
    echo "4: ls= $(ls)" >> LOG4
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG4
    echo "make -f Makefile" >> LOG4
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG4
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG4
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG4
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG4
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG4
    echo "PACKAGES = ${PACKAGES}" >> LOG4
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG4
    echo "BPN=${BPN}" >> LOG4
    echo "BP=${BP}" >> LOG4
    echo "PN=${PN}" >> LOG4
    echo "PR=${PR}" >> LOG4
    echo "PV=${PV}" >> LOG4
    echo "PE=${PE}" >> LOG4
    echo "PF=${PF}" >> LOG4
    echo "S=${S}" >> LOG4
    echo "P=${P}" >> LOG4
    echo "B=${B}" >> LOG4
    echo "D=${D}" >> LOG4
    echo "sysconfdir=${sysconfdir}" >> LOG4
    echo "localdir=${localdir}" >> LOG4
    echo "dir = ${dir}" >> LOG4
    echo "libdir=${libdir}" >> LOG4
    echo "bindir=${bindir}" >> LOG4
    echo "sbindir=${sbindir}" >> LOG4
    echo "datadir=${datadir}" >> LOG4
    echo "includedir=${includedir}" >> LOG4
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG4
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG4
    echo "systemd_libdir=${systemd_libdir}" >> LOG4
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG4
    echo "MACHINE=${MACHINE}" >> LOG4
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG4
    echo "TARGET_OS=${TARGET_OS}" >> LOG4
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG4
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG4
    echo "TOPDIR=${TOPDIR}" >> LOG4
    echo "TMPDIR=${TMPDIR}" >> LOG4
    echo "LAYERDIR=${LAYERDIR}" >> LOG4
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG4
    echo "FILESPATH=${FILESPATH}" >> LOG4
    echo "FILE=${FILE}" >> LOG4
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG4
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG4
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG4
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG4
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG4
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG4
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG4
    echo "PROVIDES=${PROVIDES}" >> LOG4
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG4
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG4
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG4
    echo "RPROVIDES=${RPROVIDES}" >> LOG4
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG4
    echo "RREPLACES=${RREPLACES}" >> LOG4
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG4

    echo "env:" >> LOG4
    echo "$(env)" >> LOG4
    echo "export:" >> LOG4
    echo "$(export)" >> LOG4
#    make clean
    make
}

do_compile_append() {
    echo "JACK_WANG_DISTRO=${JACK_WANG_DISTRO} " >> LOG4
    echo "JACK_WANG_MACHINE=${JACK_WANG_MACHINE} " >> LOG4
    echo "do_compile_append(): jack1.bb" >> LOG4
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG4
}

do_clean_apped() {
    echo "cleanup" >> LOG4
}




do_install_append () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/app-recipe1.c  ${D}${bindir}

}
