import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    hmr: {
      host: 'library-bjeh.onrender.com',
      protocol: 'wss', // Use WebSocket Secure since your site uses HTTPS
    },
    host: '0.0.0.0', // This allows connections from any IP address
    port: 3000, // Ensure this port is open in Render's settings
  },
});
