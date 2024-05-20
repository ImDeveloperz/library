import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    hmr: {
      host: 'library-bjeh.onrender.com',
      protocol: 'wss', // Use WebSocket Secure since your site uses HTTPS
    },
    protocol: 'wws',
    host: 'library-bjeh.onrender.com',
  },
});
