# Game Rules

This game involves different character classes and their battle mechanics:

- **Monster:** Attacks and receives damage based on its strength. For instance, if the monster has 10 health and is attacked with a strength of 5, it loses 5 health. When the monster attacks, its attack strength remains the same as the initial value mentioned in the corresponding field.

- **Mage:** Attacks with twice the attack strength if enough mana is available. Each attack consumes 1 mana. If the mage has less than 1 mana, it doesn't inflict any damage. When the mage takes damage, it restores 0.2 mana.

- **Warrior:** Attacks with the exact strength as indicated in their attack strength value. Damage received is reduced by half of the armor value. For example, if a warrior has 10 health and 2 armor, and is attacked with a strength of 4, it takes 3 units of damage instead of 4.

- **Archer:** Attacks and receives damage without modifications. When attacking, there's a 20% chance to deal double damage. When receiving damage, there's a 25% chance to evade the attack and receive 0 damage.

Console logs will display all actions taking place in these methods.

For instance:

- "Monster (name) received 4 damage! Now its health is 1."
- "Archer (name) evaded the attack!"
- "Mage (name) couldn't attack as their mana was depleted!"
- "Monster (monster's name) attacks player (player's name) with a strength of 3!"
- "Mage (player's name) attacks monster (monster's name) with a strength of 6!"

## Gameplay

- Begin by asking the user to select a combat class (a number from 1 to 3).
- Next, ask for the player's name.
- Set fixed values for attack, health, and unique fields for player objects.
- Create a random monster with attack and health values in the range from 1 to 20.
- Display the player and monster information in the console before the battle begins.
- Combat involves alternating attacks between the player and the monster.
- After each round of attacks, prompt "continue battle?". If the user inputs "yes," the battle continues; otherwise, it ends in a draw.
- The battle continues until the monster is defeated (display a victory message) or until the player is defeated (display a defeat message).

