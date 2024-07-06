# Define the compiler
CXX = g++

# Define the compiler flags
CXXFLAGS = -Wall -std=c++11

# Define the target executable
TARGET = ht

# Find all .cpp files in the current directory
SRCS = $(wildcard *.cpp)

# Define the object files from the .cpp files
OBJS = $(SRCS:.cpp=.o)

# Default target
all: $(TARGET)

# Rule to link object files to create the executable
$(TARGET): $(OBJS)
	$(CXX) $(CXXFLAGS) -o $(TARGET) $(OBJS)

# Rule to compile .cpp files to .o files
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Clean up the build
clean:
	rm -f $(OBJS) $(TARGET)

.PHONY: all clean