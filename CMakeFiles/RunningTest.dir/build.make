# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/rid1hady/Engisubs

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/rid1hady/Engisubs

# Include any dependencies generated for this target.
include CMakeFiles/RunningTest.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/RunningTest.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/RunningTest.dir/flags.make

CMakeFiles/RunningTest.dir/Test_Object.cpp.o: CMakeFiles/RunningTest.dir/flags.make
CMakeFiles/RunningTest.dir/Test_Object.cpp.o: Test_Object.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/rid1hady/Engisubs/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/RunningTest.dir/Test_Object.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/RunningTest.dir/Test_Object.cpp.o -c /home/rid1hady/Engisubs/Test_Object.cpp

CMakeFiles/RunningTest.dir/Test_Object.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/RunningTest.dir/Test_Object.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/rid1hady/Engisubs/Test_Object.cpp > CMakeFiles/RunningTest.dir/Test_Object.cpp.i

CMakeFiles/RunningTest.dir/Test_Object.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/RunningTest.dir/Test_Object.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/rid1hady/Engisubs/Test_Object.cpp -o CMakeFiles/RunningTest.dir/Test_Object.cpp.s

CMakeFiles/RunningTest.dir/Test_Object.cpp.o.requires:

.PHONY : CMakeFiles/RunningTest.dir/Test_Object.cpp.o.requires

CMakeFiles/RunningTest.dir/Test_Object.cpp.o.provides: CMakeFiles/RunningTest.dir/Test_Object.cpp.o.requires
	$(MAKE) -f CMakeFiles/RunningTest.dir/build.make CMakeFiles/RunningTest.dir/Test_Object.cpp.o.provides.build
.PHONY : CMakeFiles/RunningTest.dir/Test_Object.cpp.o.provides

CMakeFiles/RunningTest.dir/Test_Object.cpp.o.provides.build: CMakeFiles/RunningTest.dir/Test_Object.cpp.o


CMakeFiles/RunningTest.dir/Test_Cell.cpp.o: CMakeFiles/RunningTest.dir/flags.make
CMakeFiles/RunningTest.dir/Test_Cell.cpp.o: Test_Cell.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/rid1hady/Engisubs/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/RunningTest.dir/Test_Cell.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/RunningTest.dir/Test_Cell.cpp.o -c /home/rid1hady/Engisubs/Test_Cell.cpp

CMakeFiles/RunningTest.dir/Test_Cell.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/RunningTest.dir/Test_Cell.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/rid1hady/Engisubs/Test_Cell.cpp > CMakeFiles/RunningTest.dir/Test_Cell.cpp.i

CMakeFiles/RunningTest.dir/Test_Cell.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/RunningTest.dir/Test_Cell.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/rid1hady/Engisubs/Test_Cell.cpp -o CMakeFiles/RunningTest.dir/Test_Cell.cpp.s

CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.requires:

.PHONY : CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.requires

CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.provides: CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.requires
	$(MAKE) -f CMakeFiles/RunningTest.dir/build.make CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.provides.build
.PHONY : CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.provides

CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.provides.build: CMakeFiles/RunningTest.dir/Test_Cell.cpp.o


# Object files for target RunningTest
RunningTest_OBJECTS = \
"CMakeFiles/RunningTest.dir/Test_Object.cpp.o" \
"CMakeFiles/RunningTest.dir/Test_Cell.cpp.o"

# External object files for target RunningTest
RunningTest_EXTERNAL_OBJECTS =

RunningTest: CMakeFiles/RunningTest.dir/Test_Object.cpp.o
RunningTest: CMakeFiles/RunningTest.dir/Test_Cell.cpp.o
RunningTest: CMakeFiles/RunningTest.dir/build.make
RunningTest: /usr/local/lib/libgtest.a
RunningTest: CMakeFiles/RunningTest.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/rid1hady/Engisubs/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable RunningTest"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/RunningTest.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/RunningTest.dir/build: RunningTest

.PHONY : CMakeFiles/RunningTest.dir/build

CMakeFiles/RunningTest.dir/requires: CMakeFiles/RunningTest.dir/Test_Object.cpp.o.requires
CMakeFiles/RunningTest.dir/requires: CMakeFiles/RunningTest.dir/Test_Cell.cpp.o.requires

.PHONY : CMakeFiles/RunningTest.dir/requires

CMakeFiles/RunningTest.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/RunningTest.dir/cmake_clean.cmake
.PHONY : CMakeFiles/RunningTest.dir/clean

CMakeFiles/RunningTest.dir/depend:
	cd /home/rid1hady/Engisubs && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/rid1hady/Engisubs /home/rid1hady/Engisubs /home/rid1hady/Engisubs /home/rid1hady/Engisubs /home/rid1hady/Engisubs/CMakeFiles/RunningTest.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/RunningTest.dir/depend

