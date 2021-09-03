do_image_jackwang[dirs] = "${TOPDIR}"
do_image_jackwang[umask] = "022"
#do_image_jackwang[depends] += " bc-native:do_populate_sysroot bison-native:do_populate_sysroot "
#do_image_jackwang[lockfiles] += "${OSTREE_REPO}/ostree.lock"
IMAGE_CMD_jackwang () {
        echo "IMAGE_CMD_jackwang ()" > LOG1
        echo "poky/meta-IMAGE_CMD-jack/recipes-image_cmd_jack/image_cmd/core-image-minimal.bbappend " >> LOG1
        echo "inherit jack_image_type" >> LOG1
        echo "IMAGE_FSTYPES_append = \" jackwang jacknext_4 "\" >> LOG1
        echo "poky/meta-IMAGE_CMD-jack/classes/jack_image_types.bbclass " >> LOG1
}

do_image_jackwang_0[depends] += " bc-native:do_populate_sysroot bison-native:do_populate_sysroot "
#do_image_jackwang_0[lockfiles] += "${OSTREE_REPO}/ostree.lock"
do_image_jackwang_0[lockfiles] += "${WORKDIR}/jack_ostree.lock"
IMAGE_CMD_jackwang_0 () {
        echo "poky/meta-IMAGE_CMD-jack/classes/jack_image_types.bbclass " > LOG2
        echo "Hey IMAGE_CMD_jackwang_0" >> LOG2
}

IMAGE_TYPEDEP_jacknext_1= "jackwang_0"
IMAGE_CMD_jacknext_1 () {
        echo "Hey IMAGE_CMD_jacknext_1" >> LOG2
}

IMAGE_TYPEDEP_jacknext_2= "jacknext_1"
IMAGE_CMD_jacknext_2 () {
        echo "Hey IMAGE_CMD_jacknext_2" >> LOG2
}

IMAGE_TYPEDEP_jacknext_3= "jacknext_2"
IMAGE_CMD_jacknext_3 () {
        echo "Hey IMAGE_CMD_jacknext_3" >> LOG2
}

IMAGE_TYPEDEP_jacknext_4= "jacknext_3"
IMAGE_CMD_jacknext_4 () {
        echo "Hey IMAGE_CMD_jacknext_4" >> LOG2
}

