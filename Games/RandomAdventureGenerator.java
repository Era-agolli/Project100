package Games;

import java.util.Random;
import java.util.Scanner;

public class RandomAdventureGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n--- Interactive Random Adventure Generator ---\n");
        System.out.println("Your journey begins now... choose wisely, hero.\n");

        // Step 1: Choose character
        String[] characters = {
                "a brave knight sworn to protect the weak",
                "a clever wizard mastering ancient spells",
                "a swift and silent thief seeking fortune",
                "a fearless explorer driven by curiosity"
        };
        System.out.println("Choose your character:");
        for (int i = 0; i < characters.length; i++) {
            System.out.println((i + 1) + ") " + characters[i]);
        }
        System.out.print("Enter 1-4: ");
        int choice = readChoice(scanner, 1, characters.length);
        String character = characters[choice - 1];

        // Step 2: Choose setting
        String[] settings = {
                "the eerie depths of a haunted forest",
                "a mysterious and distant alien planet",
                "a shadow-covered ancient castle",
                "a forgotten temple filled with lost magic"
        };
        System.out.println("\nChoose your setting:");
        for (int i = 0; i < settings.length; i++) {
            System.out.println((i + 1) + ") " + settings[i]);
        }
        System.out.print("Enter 1-4: ");
        choice = readChoice(scanner, 1, settings.length);
        String setting = settings[choice - 1];

        // Step 3: Choose quest
        String[] quests = {
                "recover the long-lost treasure of a vanished kingdom",
                "defeat a legendary dragon feared for centuries",
                "unravel an ancient puzzle said to guard ultimate wisdom",
                "rescue a kidnapped royal who holds the fate of the realm"
        };
        System.out.println("\nChoose your quest:");
        for (int i = 0; i < quests.length; i++) {
            System.out.println((i + 1) + ") " + quests[i]);
        }
        System.out.print("Enter 1-4: ");
        choice = readChoice(scanner, 1, quests.length);
        String quest = quests[choice - 1];

        // Step 4: Multiple random events for a longer adventure
        String[] events = {
                "but a violent storm suddenly strikes, forcing you to seek shelter.",
                "when a mysterious stranger approaches with a cryptic warning.",
                "but you stumble into an ancient trap hidden beneath the ground.",
                "when a rival adventurer challenges you for your quest.",
                "and a hidden doorway reveals a secret chamber filled with symbols.",
                "as ghostly whispers echo through the air, guiding your steps.",
                "but the path splits into three tunnels, each more dangerous than the last.",
                "and a magical creature appears, offering its aid… for a price."
        };

        // Pick 2–3 random events
        int eventCount = 2 + random.nextInt(2);  // 2 or 3 events
        StringBuilder fullEvents = new StringBuilder();
        for (int i = 0; i < eventCount; i++) {
            fullEvents.append(events[random.nextInt(events.length)]).append(" ");
        }

        // Step 5: Outcome based on luck
        String[] outcomes = {
                "In the end, your courage pays off—you achieve your goal with honor.",
                "Despite your efforts, fate turns against you and your quest ends in defeat.",
                "You narrowly survive the dangers, returning home wiser than before.",
                "Your bravery attracts loyal companions, and your adventures continue.",
                "Your name becomes legendary, whispered in stories across generations."
        };
        String outcome = outcomes[random.nextInt(outcomes.length)];

        // Display full adventure
        System.out.println("\n--- Your Adventure Story ---");
        System.out.println("You are " + character + ", traveling through " + setting +
                " on a quest to " + quest + ". During your journey, " +
                fullEvents + outcome);
        System.out.println("\n🎉 Adventure Complete!");
    }

    // Helper method to read valid choice
    private int readChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) return input;
            } catch (NumberFormatException ignored) {}
            System.out.print("Invalid input. Please enter a number between "
                    + min + " and " + max + ": ");
        }
    }
}
