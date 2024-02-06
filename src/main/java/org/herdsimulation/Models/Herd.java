package org.herdsimulation.Models;

// Roaming/exploration could be interpreted as a case of the classic exploration-exploitation dilemma.
// However, other herds, the possibility of player intervention, the potential of being stuck in an enclosed space
// and the necessity to differentiate between the two scenarios demands for a split of the exploitation phase into
// domestication and roaming scenarios.
public enum Herd
{
    exploration,
    roaming,
    domestication
}