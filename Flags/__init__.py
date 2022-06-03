from tidal import *
from app import App

class FlagsApp(App):
    
    def on_activate(self):
        super().on_activate()
        self.draw_rainbow()
    
    def draw_rainbow(self):
        display.fill(RED)
        display.fill_rect(22, 0, 23, 240, color565(255, 153, 0))
        display.fill_rect(45, 0, 22, 240, YELLOW)
        display.fill_rect(67, 0, 23, 240, GREEN)
        display.fill_rect(90, 0, 22, 240, BLUE)
        display.fill_rect(112, 0, 23, 240, color565(204, 0, 255))


main = FlagsApp
