const API_BASE_URL = "https://repas"+process.env.NEXT_PUBLIC_APIURL  + "/repas";

// Define TypeScript interfaces for the entities
export interface Repas {
  id?: number; // Optional for creation
  name: string;
  ingredients: Record<string, number>;
}

// API functions

// Create a new repas
export async function createRepas(repas: Repas): Promise<Repas> {
  const response = await fetch(`${API_BASE_URL}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(repas),
  });
  if (!response.ok) throw new Error("Failed to create repas");
  return response.json();
}

// Get a repas by ID
export async function getRepasById(id: number): Promise<Repas> {
  const response = await fetch(`${API_BASE_URL}/${id}`);
  if (!response.ok) throw new Error(`Failed to fetch repas with ID ${id}`);
  return response.json();
}

// Get all repas
export async function getAllRepas(): Promise<Repas[]> {
  const response = await fetch(`${API_BASE_URL}`);
  if (!response.ok) throw new Error("Failed to fetch repas");
  return response.json();
}

// Delete a repas
export async function deleteRepas(id: number): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) throw new Error(`Failed to delete repas with ID ${id}`);
}
