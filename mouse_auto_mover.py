#!/usr/bin/env python3
import threading
import time
import pyautogui

class MouseMover:
    def __init__(self):
        self.running = False
        self.thread = None

    def start(self):
        if not self.running:
            self.running = True
            self.thread = threading.Thread(target=self.scroll_mouse, daemon=True)
            self.thread.start()
            self.thread.join()  # Wait for thread to finish

    def stop(self):
        self.running = False

    def scroll_mouse(self):
        start_time = time.time()
        # Scroll up for 2.5 seconds
        while self.running and time.time() - start_time < 2.5:
            try:
                pyautogui.scroll(100)  # Scroll up
                time.sleep(0.1)
            except Exception as e:
                print(f"Error scrolling: {e}")
                self.running = False
        # Scroll down for 2.5 seconds
        while self.running and time.time() - start_time < 5:
            try:
                pyautogui.scroll(-100)  # Scroll down
                time.sleep(0.1)
            except Exception as e:
                print(f"Error scrolling: {e}")
                self.running = False
        self.running = False

if __name__ == "__main__":
    mover = MouseMover()
    mover.start()
