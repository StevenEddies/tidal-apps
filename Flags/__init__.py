from tidal import *
from app import App

class FlagsApp(App):
    
    def __init__(self):
        super().__init__()
        self.current_index = 0
        self.flags = [
            self.draw_rainbow
        ]
    
    def on_activate(self):
        super().on_activate()
        self.draw_current()
    
    def draw_current(self):
        self.flags[self.current_index]()
	
    def draw_rainbow(self):
        display.fill(RED)
        display.fill_rect(22, 0, 23, 240, color565(255, 204, 0))
        display.fill_rect(45, 0, 22, 240, YELLOW)
        display.fill_rect(67, 0, 23, 240, GREEN)
        display.fill_rect(90, 0, 22, 240, BLUE)
        display.fill_rect(112, 0, 23, 240, color565(204, 0, 255))


main = FlagsApp
