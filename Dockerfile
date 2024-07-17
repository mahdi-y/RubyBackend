# Use the official OpenJDK 17 JDK slim image
FROM openjdk:17-jdk-slim

# Install necessary tools
RUN apt-get update && \
    apt-get install -y iputils-ping dnsutils curl && \
    rm -rf /var/lib/apt/lists/*

# Set the entrypoint (adjust as needed)
CMD ["bash"]
