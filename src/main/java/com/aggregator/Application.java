package com.aggregator;

import com.aggregator.cli.CLI;

import java.util.Arrays;

/**
 * Main entry point for the REST API Aggregator application.
 */
public class Application {
    public static void main(String[] args) {
        try {
            CLI cli = new CLI();
            
            if (args.length == 0) {
                // Default to interactive mode
                cli.runInteractiveMode();
            } else if (args[0].equals("-i")) {
                cli.runInteractiveMode();
            } else if (args[0].equals("-a")) {
                // Automatic mode
                cli.runAutomaticMode(Arrays.copyOfRange(args, 1, args.length));
            } else {
                printUsage();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void printUsage() {
        System.out.println("Usage: java -jar aggregator.jar [MODE] [OPTIONS]");
        System.out.println();
        System.out.println("Modes:");
        System.out.println("  -i              Interactive mode (default)");
        System.out.println("  -a              Automatic mode");
        System.out.println();
        System.out.println("Automatic mode options:");
        System.out.println("  --apis API1,API2,API3    Comma-separated API names");
        System.out.println("  --format json|csv         Output format");
        System.out.println("  --output FILE             Output file path");
        System.out.println("  --threads N               Max concurrent tasks (default: 3)");
        System.out.println("  --interval N              Poll interval in seconds (default: 60)");
    }
}
