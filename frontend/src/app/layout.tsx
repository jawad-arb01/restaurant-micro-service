import type { Metadata } from "next";
import "./globals.css";



export const metadata: Metadata = {
  title: "Restaurant api ",
  description: "CI/CD and deployment of a microservices app in the cloud",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        {children}
      </body>
    </html>
  );
}
