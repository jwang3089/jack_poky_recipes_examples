KBRANCH ?= "v5.4/standard/base"

require recipes-kernel/linux/linux-yocto.inc

# board specific branches
KBRANCH_qemuarm  ?= "v5.4/standard/arm-versatile-926ejs"
KBRANCH_qemuarm64 ?= "v5.4/standard/qemuarm64"
KBRANCH_qemumips ?= "v5.4/standard/mti-malta32"
KBRANCH_qemuppc  ?= "v5.4/standard/qemuppc"
KBRANCH_qemuriscv64  ?= "v5.4/standard/base"
KBRANCH_qemux86  ?= "v5.4/standard/base"
KBRANCH_qemux86-64 ?= "v5.4/standard/base"
KBRANCH_qemumips64 ?= "v5.4/standard/mti-malta64"

#SRCREV_machine_qemuarm ?= "f367cbe6d0c21c65257c66a4c9b1845fd43285f8"
#SRCREV_machine_qemuarm64 ?= "8dcb7ee83e58da8bf51ed8b72165e1ed35beb928"
#SRCREV_machine_qemumips ?= "3d4c6263bfdf95960894b75c76aa450d240e3e8e"
#SRCREV_machine_qemuppc ?= "125a824c8d14c49b640bc0d6e040d495177caa10"
#SRCREV_machine_qemuriscv64 ?= "997c04e7a40084a53bc3d45490949584364697bd"
#SRCREV_machine_qemux86 ?= "997c04e7a40084a53bc3d45490949584364697bd"
#SRCREV_machine_qemux86-64 ?= "997c04e7a40084a53bc3d45490949584364697bd"
#SRCREV_machine_qemumips64 ?= "7082f58984404a5aad90bca1dac4e27773fff26e"
#SRCREV_machine ?= "997c04e7a40084a53bc3d45490949584364697bd"
SRCREV_meta ?= "231d3a07e10680c7c89ea101cd803b0684482b11"

# remap qemuarm to qemuarma15 for the 5.4 kernel
# KMACHINE_qemuarm ?= "qemuarma15"

# JACK SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
#           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
# ERROR: linux-yocto-5.4.135-r0 do_populate_lic: QA Issue: linux-yocto: The LIC_FILES_CHKSUM does not match for file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7
# JACK LINUX_VERSION ?= "5.4.135"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

# JACK PV = "${LINUX_VERSION}+git${SRCPV}"
# It will read the Makefile and comape to PV
PV = "5.4.135"
#
S = "${WORKDIR}"

SRC_URI = "file://*.*; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}"
#if not defined this, error at beloww: SRC_URI =" git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}; \
#ERROR: linux-yocto-5.4-r0 do_kernel_metadata: Could not locate BSP definition for qemux86-64/standard and no defconfig was provided
#ERROR: linux-yocto-5.4-r0 do_kernel_metadata: Execution of '/media/jackbwang/SAMPLE/YOCTO/poky/build/tmp/work/qemux86_64-poky-linux/linux-yocto/5.4-r0/temp/run.do_kernel_metadata.5138' failed with exit code 1:
#WARNING: exit code 1 from a shell command.
#ERROR: Logfile of failure stored in: /media/jackbwang/SAMPLE/YOCTO/poky/build/tmp/work/qemux86_64-poky-linux/linux-yocto/5.4-r0/temp/log.do_kernel_metadata.5138
#	file://*.*" \
#"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

KERNEL_DEVICETREE_qemuarmv5 = "versatile-pb.dtb"

COMPATIBLE_MACHINE = "qemuarm|qemuarmv5|qemuarm64|qemux86|qemuppc|qemumips|qemumips64|qemux86-64|qemuriscv64"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES_append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES_append_qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc"
KERNEL_FEATURES_append_qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append_qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "" ,d)}"
KERNEL_FEATURES_append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/scsi/scsi-debug.scc", "" ,d)}"

do_deploy_append() {
    echo "****************** JACK 1 *********************" > LOG1
    echo "jack do_deplo_append() " >> LOG1
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG1
    echo "0: INCLUDE = ${INCLUDE}" >> LOG1
    echo "0: SRC_URI = ${SRC_URI}" >> LOG1
    echo "0: WORKDIR = ${WORKDIR}" >> LOG1
    echo "2: S = ${S}" >> LOG1
    echo "3: pwd = $(pwd)" >> LOG1
    echo "4: ls= $(ls)" >> LOG1
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG1
    echo "classes/package_rpm.bbclass: PKGWRITEDIRRPM = \"${WORKDIR}/deploy-rpms" >> LOG1
    echo "PKGWRITEDIRRPM = ${PKGWRITEDIRRPM}" >> LOG1
    echo "recipes-kernel/linux/linux-yocto.inc: B = \"${WORKDIR}/linux-${PACKAGE_ARCH}-${LINUX_KERNEL_TYPE}-build" >> LOG2
    echo "B=${B}: ${WORKDIR}/linux-${PACKAGE_ARCH}-${LINUX_KERNEL_TYPE}-build " >> LOG2
    echo "LINUX_KERNEL_TYPE= ${LINUX_KERNEL_TYPE}" >> LOG1
    echo "make -f Makefile" >> LOG1
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG1
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG1
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG1
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG1
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG1
    echo "PACKAGES = ${PACKAGES}" >> LOG1
    echo "FILES_${PN} = ${FILES_${PN}}" >> LOG1
    echo "BPN=${BPN}" >> LOG1
    echo "BP=${BP}" >> LOG1
    echo "PN=${PN}" >> LOG1
    echo "PR=${PR}" >> LOG1
    echo "PV=${PV}" >> LOG1
    echo "PE=${PE}" >> LOG1
    echo "PF=${PF}" >> LOG1
    echo "S=${S}" >> LOG1
    echo "P=${P}" >> LOG1
    echo "B=${B}" >> LOG1
    echo "D=${D}" >> LOG1
    echo "sysconfdir=${sysconfdir}" >> LOG1
    echo "localdir=${localdir}" >> LOG1
    echo "dir = ${dir}" >> LOG1
    echo "libdir=${libdir}" >> LOG1
    echo "bindir=${bindir}" >> LOG1
    echo "sbindir=${sbindir}" >> LOG1
    echo "datadir=${datadir}" >> LOG1
    echo "includedir=${includedir}" >> LOG1
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG1
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG1
    echo "systemd_libdir=${systemd_libdir}" >> LOG1
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG1
    echo "MACHINE=${MACHINE}" >> LOG1
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG1
    echo "TARGET_OS=${TARGET_OS}" >> LOG1
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG1
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG1
    echo "TOPDIR=${TOPDIR}" >> LOG1
    echo "TMPDIR=${TMPDIR}" >> LOG1
    echo "LAYERDIR=${LAYERDIR}" >> LOG1
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG1
    echo "FILESPATH=${FILESPATH}" >> LOG1
    echo "FILE=${FILE}" >> LOG1
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG1
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG1
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG1
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG1
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG1
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG1
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG1
    echo "PROVIDES=${PROVIDES}" >> LOG1
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG1
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG1
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG1
    echo "RPROVIDES=${RPROVIDES}" >> LOG1
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG1
    echo "RREPLACES=${RREPLACES}" >> LOG1
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG1

    echo "env:" >> LOG1
    echo "$(env)" >> LOG1
    echo "printenv:" >> LOG1
    echo "$(printenv)" >> LOG1
    echo "export:" >> LOG1
    echo "$(export)" >> LOG1

}
