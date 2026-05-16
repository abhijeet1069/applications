# WireMock

WireMock can simulate an entire HTTP API—including endpoints, responses, headers, status codes, 
delays, and failures—because it behaves like a real HTTP server, not just a mocked method.

## Flow

Application
↓
HTTP request
↓
WireMock server
↓
Find matching stub
↓
Return fake response

## Mappings vs Files

Folder      Purpose

mappings    stub definitions
__files     response payloads