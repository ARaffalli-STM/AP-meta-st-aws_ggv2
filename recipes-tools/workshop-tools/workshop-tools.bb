DESCRIPTION = "Additional scripts for the workshop"
SECTION = "extras"
LICENSE = "CLOSED"
PR = "1.0"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://read_sensor.sh"
SRC_URI += "file://read_sensor.py"
SRC_URI += "file://51-wireless.network"
SRC_URI += "file://wpa_supplicant/wpa_supplicant-wlan0.conf"
SRC_URI += "file://rtlwifi/rtl8188eufw.bin"

FILES:${PN} += "/home/root/read_sensor.sh"
FILES:${PN} += "/home/root/read_sensor.py"
FILES:${PN} += "/lib/systemd/network/51-wireless.network"
FILES:${PN} += "/etc/wpa_supplicant/wpa_supplicant-wlan0.conf"
FILES:${PN} += "/lib/firmware/rtlwifi/rtl8188eufw.bin"

do_compile() {
}

do_install() {
	install -d ${D}/home/root/ 
	install -d ${D}/lib/systemd/network/ 
	install -m 0755 ${WORKDIR}/read_sensor.sh ${D}/home/root/read_sensor.sh
	install -m 0755 ${WORKDIR}/read_sensor.py ${D}/home/root/read_sensor.py
	install -m 0755 ${WORKDIR}/51-wireless.network ${D}/lib/systemd/network/51-wireless.network
	install -d ${D}/etc/wpa_supplicant/
	install -m 0644 ${WORKDIR}/wpa_supplicant/wpa_supplicant-wlan0.conf ${D}/etc/wpa_supplicant/
	install -d ${D}/lib/firmware/rtlwifi/
	install -m 0644 ${WORKDIR}/rtlwifi/rtl8188eufw.bin ${D}/lib/firmware/rtlwifi/
}

RDEPENDS:${PN} = "bash"
RDEPENDS:${PN} += "python3-core python3-pygobject gtk+3 python3-resource python3-threading"
