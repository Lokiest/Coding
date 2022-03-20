def solution(bridge_length, weight, truck_weights):
    answer = 0
    trucks_on_bridge = [0] * bridge_length
    
    while len(trucks_on_bridge) != 0:
        answer += 1
        trucks_on_bridge.pop(0)
        
        if len(truck_weights) != 0:
            if sum(trucks_on_bridge) + truck_weights[0] <= weight:
                trucks_on_bridge.append(truck_weights.pop(0))
            else:
                trucks_on_bridge.append(0)
                
    return answer
