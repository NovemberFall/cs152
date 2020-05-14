import sublime
import sublime_plugin

import subprocess  

class ExampleCommand(sublime_plugin.TextCommand):
	def run(self, edit):
		self.view.insert(edit, 0, "Hello, World!")


def fileext(path):
    filesplit = path.split('.')
    return filesplit[len(filesplit) - 1]


def parentdir(path):
    pathsplit = path.split('/')
    return '/'.join(pathsplit[:len(pathsplit) - 1])


class BycoexecCommand(sublime_plugin.TextCommand):

    def run(self, view):

        filepath = self.view.file_name()
        path = parentdir(filepath)

        if fileext(filepath) == 'byco':

            command = "ruby %s/vm.rb %s" % (path, filepath)
            proc = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
            for ln in proc.stdout:
                print(ln.decode('utf-8').rstrip('\n'))


class EventListener(sublime_plugin.EventListener):

    def on_post_save(self, view):
        print("Saved!")
        # Get names and stuff
        filepath = view.file_name()
        ext = fileext(filepath)
        destpath = filepath.replace(ext, "byco")  
        path = parentdir(filepath)

        if ext == 'myscm':

            command = "ruby %s/compiler.rb %s %s" % (path, filepath, destpath)
            subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
            print("ran %s" % command)
