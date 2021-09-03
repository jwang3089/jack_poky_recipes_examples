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
