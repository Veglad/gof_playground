class Vga:
    def __init__(self, voltage):
        self.voltage = voltage

class Hdmi:
    def __init__(self, voltage):
        self.highVoltage = voltage

class Monitor:
    def __init__(self, hdmi):
        self.data = hdmi.highVoltage
    
    def display(self):
        print("Displaying viedoo with voltage: " + str(self.data))

class VgaHdmiAdapter:
    def __init__(self, vga):
        self.highVoltage = vga.voltage + 5

if __name__ == "__main__":
    vga = Vga(10)
    monitor = Monitor(VgaHdmiAdapter(vga))
    monitor.display()