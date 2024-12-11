const API_BASE_URL = "https://client"+process.env.NEXT_PUBLIC_APIURL + "/clients";

// Define TypeScript interfaces for the DTOs and entities
export interface Client {
  id?: number; // Optional for creation
  name: string;
  email: string;
  phone: string;
  address: string;
}

interface Repas {
  id: number;
  name: string;
  ingredients: Record<string, number>;
}

interface ClientRepasDTO {
  client: Client;
  repas: Repas;
}

// API functions

// Create a new client
export async function createClient(client: Client): Promise<Client> {
  const response = await fetch(`${API_BASE_URL}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(client),
  });
  if (!response.ok) throw new Error("Failed to create client");
  return response.json();
}

// Get a client by ID
export async function getClientById(id: number): Promise<Client> {
  const response = await fetch(`${API_BASE_URL}/${id}`);
  if (!response.ok) throw new Error(`Failed to fetch client with ID ${id}`);
  return response.json();
}

// Get all clients
export async function getAllClients(): Promise<Client[]> {
  const response = await fetch(`${API_BASE_URL}`);
  if (!response.ok) throw new Error("Failed to fetch clients");
  return response.json();
}

// Update a client
export async function updateClient(id: number, client: Client): Promise<Client> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(client),
  });
  if (!response.ok) throw new Error(`Failed to update client with ID ${id}`);
  return response.json();
}

// Get client and meal details
export async function getClientAndMealDetails(clientId: number, repasId: number): Promise<ClientRepasDTO> {
  const response = await fetch(`${API_BASE_URL}/${clientId}/order/${repasId}`);
  if (!response.ok) throw new Error(`Failed to fetch client and meal details for IDs ${clientId} and ${repasId}`);
  return response.json();
}

// Get all meals
export async function getAllMeals(): Promise<Repas[]> {
  const response = await fetch(`${API_BASE_URL}/getAllRepas`);
  if (!response.ok) throw new Error("Failed to fetch meals");
  return response.json();
}

// Delete a client
export async function deleteClient(id: number): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/delete/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) throw new Error(`Failed to delete client with ID ${id}`);
}
