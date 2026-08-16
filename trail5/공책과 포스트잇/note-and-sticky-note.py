n, k, l = map(int, input().split())
notes = list(map(int, input().split()))
notes = sorted(notes, reverse = True)
def getH_index(notes, k, l, num):
    count = 0
    remain = k*l
    for note in notes:
        if note >= num:
            count +=1
            continue
        if num - note > k:
            break
        if remain < num - note:
            break
        else:
            count +=1
            remain -= num-note 
    return count if count <= num else num
def bsearch(notes, k, l, low, high):
    while(low < high):
        mid = (low+high)//2
        h_index= getH_index(notes,k,l,mid)
      
        if h_index < mid:
            high = mid
        else:
            low = mid+1
    return max(getH_index(notes,k,l,low), getH_index(notes,k,l,low-1))

print(bsearch(notes,k,l,1,n))

