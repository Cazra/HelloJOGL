HelloJOGL
=========

Stand-alone hello world project for JOGL 2.1, easily runnable from command line.

----

To build: 

Debug:
From the root directory, open a command line and run 'ant clean all'.
This will create a "project.jar" in the "/latest" directory containing 
everything for your project except the JOGL libraries.

Release:
Alternatively, run "ant clean dist" instead. This will create a "project.jar" 
and a "project-natives-windows-amd64.jar" file in the "/dist" directory. The 
"project.jar" file contains everything for your project, including the JOGL
libraries. The "project-natives-windows-amd64.jar" file contains the native 
dlls used by JOGL which will be found at runtime. Note that this method will
take much longer to build though, so I only recommend this method for creating
the distribution.

----

To run:

To run the project jar in "/latest", run "run.bat". It will take care of 
setting up the classpath so that the JOGL libraries are linked in. 

To run the project jar in "/dist", run 'java -jar dist/project.jar' from
command line.

----

Note on the native JOGL DLLs:

This example assumes you are using 64-bit Windows. You'll need to get other 
appropriate native JOGL dlls if this is not the case. All the native dll jars 
come packaged with JOGL on the JOGL website: http://jogamp.org/

The current version of JOGL can be downloaded here (requires 7-zip): 
http://jogamp.org/deployment/jogamp-current/archive/

The file containing the meat of JOGL is 'jogamp-all-platforms.7z'. 
Look for the 'natives' jar files in the 'jar' folder of the archive.

Just drop the jars with the native libraries you need in the "/jogl"
directory and change the ant build file to include them in the 
"project-natives-*.jar" for in the 'dist' target.
