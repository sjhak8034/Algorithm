DUMMY = -1
MAX_ID = 100000001
N, M, Q = map(int, input().split())

circle_size = []
student_nums = []



for _ in range(M):
    nums = list(map(int, input().split()))
    circle_size.append(nums[0])
    student_nums.append(nums[1:])

command = []
A = []
B = []

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

# 노드 u 뒤에 단일 노드 singleton를 삽입
def insert_next(u, singleton):
    # singleton의 prev와 next를 설정
    singleton.prev = u
    singleton.next = u.next

    # singleton의 이전 노드의 next와
    # 다음 노드의 prev를 설정       
    if singleton.prev is not None:
        singleton.prev.next = singleton
    if singleton.next is not None:
        singleton.next.prev = singleton
def insert_prev(u, singleton):
    singleton.prev = u.prev
    singleton.next = u
    
    # singleton의 이전 노드의 next와
    # 다음 노드의 prev를 설정
    if singleton.prev is not None:
        singleton.prev.next = singleton
    if singleton.next is not None:
        singleton.next.prev = singleton
def pop(u):
    # u의 이전 노드와 다음 노드를 서로 이어줌
    if u.prev is not None:
        u.prev.next = u.next
    if u.next is not None:
        u.next.prev = u.prev

    # 이제, u는 단일 노드가 됨
    u.prev = u.next = None

nodes = {}

for i in range(M):
    students = student_nums[i]
    c_size = circle_size[i]
    root = Node(DUMMY)
    root.next = root          # 처음부터 원형으로
    root.prev = root
    prev = root
    for student in students:
        current = Node(student)
        insert_next(prev,current)
        nodes[student] = current
        prev = current
    pop(root)


for _ in range(Q):
    query = list(map(int, input().split()))
    command.append(query[0])
    A.append(query[1])
    if query[0] in [1, 2]:
        B.append(query[2])
    else:
        B.append(0)

for i in range(Q):
    a = A[i]
    b = B[i]
    c = command[i]
    

    if c == 1:
        a_node, b_node = nodes[a], nodes[b]
        a_next, b_prev = a_node.next, b_node.prev
        a_node.next = b_node
        b_node.prev = a_node
        b_prev.next = a_next
        a_next.prev = b_prev
    if c == 2:
        a_node, b_node = nodes[a], nodes[b]
        a_prev, b_prev = a_node.prev, b_node.prev
        a_node.prev = b_prev     # 새 원:  A ... B_prev
        b_prev.next = a_node
        b_node.prev = a_prev     # 남은 원: B ... A_prev
        a_prev.next = b_node
    if c == 3:
        a_node = nodes[a]
        minData = a_node.data
        node = a_node.next
        while(node.data != a):
            minData = min(minData, node.data)
            node = node.next
        print(minData, end = " ")
        node = nodes[minData].prev
        while(node.data != minData):
            print(node.data, end = " ")
            node = node.prev
        
        
