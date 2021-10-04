
#
#FILESEXTRAPATHS_prepend := "${THISDIR}/files:" 
#
SUMMARY = "Hello World Demo"
SECTION = "apps"
LICENSE = "CLOSED"

PR = "r24"
SUMMARY = "Provides driver packages for u-blox short-range radio modules"
DESCRIPTION = "Meta group for u-blox radio modules"

inherit packagegroup

PROVIDES = "${PN}"

# Use all modules if not specified otherwise
##    ${@bb.utils.contains('BB_UTILS_CONTAINS_FEATURES', 'jack-options', 'present', 'notpresent', d)}
BB_UTILS_CONTAINS_FEATURES ?= "jack-options"
SOMEFLAG = "a b c"

# below will run jack-bb-utils-contains recipe
RDEPENDS_${PN} = " \
    ${@bb.utils.contains('BB_UTILS_CONTAINS_FEATURES', 'jack-options', 'jack-bb-utils-contains', 'jack-bb-utils-contains', d) } \
"

# ENV bitbake -e jack-utils-contains | grep NEWVALUE1
NEWVALUE1="${@bb.utils.contains('SOMEFLAG', 'a', 'present', 'notpresent', d)}" 
NEWVALUE2="${@bb.utils.contains('SOMEFLAG', 'a b', 'present', 'notpresent', d)}" 
NEWVALUE3="${@bb.utils.contains('SOMEFLAG', 'a b c', 'present', 'notpresent', d)}"
NEWVALUE4="${@bb.utils.contains('SOMEFLAG', 'a d', 'present', 'notpresent', d)}" 

#    NEWVALUE1="${@bb.utils.contains('SOMEFLAG', 'a', 'present', 'notpresent', d)}" 
#    NEWVALUE2="${@bb.utils.contains('SOMEFLAG', 'a b', 'present', 'notpresent', d)}" 
#    NEWVALUE3="${@bb.utils.contains('SOMEFLAG', 'a b c', 'present', 'notpresent', d)}" 
#    NEWVALUE4="${@bb.utils.contains('SOMEFLAG', 'a d', 'present', 'notpresent', d)}" 
