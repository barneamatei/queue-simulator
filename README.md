# Queue Simulation App

## Overview
This project is a Queue Simulation System developed in Java. It models customer queues using different allocation strategies, enabling users to configure parameters, visualize real-time results, and generate statistical reports.

## Features

- **Dynamic Queue Simulation:** Multiple queues with adaptive allocation.
- **Multithreading:** Each queue runs in a separate thread for parallel processing.
- **Thread Synchronization:** Ensures safe data handling across threads.
- **Allocation Strategies:**
  - Shortest Time First
  - Shortest Queue First
- **Graphical User Interface (GUI):** Built with Java Swing for real-time visualization.
- **Result Export:** Simulation outcomes are saved to files for further analysis.
- **Statistical Insights:** Key metrics include:
  - Average Waiting Time
  - Peak Hour
  - Average Service Time

## Technologies Used

- **Programming Language:** Java
- **GUI Framework:** Swing
- **Concurrency Handling:** BlockingQueue for thread-safe queue management
- **File I/O:** Data persistence and report generation

## How It Works

1. The user sets simulation parameters, including:
   - Number of clients
   - Number of queues
   - Simulation time
   - Arrival and service time intervals
2. The system assigns customers to queues based on the selected allocation strategy.
3. The GUI updates in real-time to reflect queue activity.
4. Final statistics are displayed in the GUI and saved to a file for analysis.

This application provides a powerful tool for analyzing queue dynamics, improving service efficiency, and studying different queuing strategies.

